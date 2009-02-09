package org.exigencecorp.gen;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.exigencecorp.util.Interpolate;
import org.exigencecorp.util.StringBuilderr;

public class GField {

    private final GClass gclass;
    private final String name;
    private String typeClassName;
    private String initialValue;
    private GClass initialAnonymousClass;
    private String access = "private";
    private boolean isStatic;
    private boolean isFinal;
    private final List<String> annotations = new ArrayList<String>();

    public GField(GClass gclass, String name) {
        this.gclass = gclass;
        this.name = name;
    }

    public String toCode() {
        StringBuilderr s = new StringBuilderr();
        for (String annotation : this.annotations) {
            s.line(annotation);
        }
        s.append(this.access);
        if (this.isStatic) {
            s.append(" static");
        }
        if (this.isFinal) {
            s.append(" final");
        }
        s.append(" {}", this.typeClassName);
        s.append(" {}", this.name);
        if (this.initialValue != null) {
            s.append(" = {}", this.initialValue);
        }
        if (this.initialAnonymousClass != null) {
            s.append(" = {}", this.initialAnonymousClass.toCode());
            s.stripTrailingNewLine();
        }
        s.line(";");
        return s.toString();
    }

    public String getName() {
        return this.name;
    }

    public GField type(Class<?> type) {
        return this.type(type.getName());
    }

    public GField type(String fullClassName, Object... args) {
        this.typeClassName = this.gclass.stripAndImportPackageIfPossible(Interpolate.string(fullClassName, args));
        return this;
    }

    public GField initialValue(String initialValue, Object... args) {
        this.initialValue = Interpolate.string(initialValue, args);
        return this;
    }

    public GClass initialAnonymousClass() {
        GClass gc = new GClass(this.typeClassName).setAnonymous();
        this.initialAnonymousClass = gc;
        return gc;
    }

    public GField setStatic() {
        this.isStatic = true;
        return this;
    }

    public GField setFinal() {
        this.isFinal = true;
        return this;
    }

    public GField setPublic() {
        this.access = "public";
        return this;
    }

    public GField setProtected() {
        this.access = "protected";
        return this;
    }

    public String toString() {
        return this.toCode();
    }

    public GMethod makeGetter() {
        GMethod getter = this.gclass.getMethod("get" + StringUtils.capitalize(this.name));
        getter.returnType(this.typeClassName);
        // getter.body.line("this.{} = {};", this.name, this.name);
        getter.body.line("return this.{};", this.name);
        return getter;
    }

    public GField addAnnotation(String annotation) {
        this.annotations.add(annotation);
        return this;
    }

}
