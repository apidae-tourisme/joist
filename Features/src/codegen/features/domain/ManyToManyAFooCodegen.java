package features.domain;

import features.domain.ManyToManyAFooAlias;
import features.domain.ManyToManyAFooToBarAlias;
import features.domain.queries.ManyToManyAFooQueries;
import java.util.ArrayList;
import java.util.List;
import org.exigencecorp.domainobjects.AbstractDomainObject;
import org.exigencecorp.domainobjects.Id;
import org.exigencecorp.domainobjects.Shim;
import org.exigencecorp.domainobjects.orm.AliasRegistry;
import org.exigencecorp.domainobjects.orm.ForeignKeyListHolder;
import org.exigencecorp.domainobjects.uow.UoW;
import org.exigencecorp.domainobjects.validation.rules.MaxLength;
import org.exigencecorp.domainobjects.validation.rules.NotNull;
import org.exigencecorp.util.Copy;

abstract class ManyToManyAFooCodegen extends AbstractDomainObject {

    static {
        AliasRegistry.register(ManyToManyAFoo.class, new ManyToManyAFooAlias("a"));
    }

    public static final ManyToManyAFooQueries queries = new ManyToManyAFooQueries();
    private Id<ManyToManyAFoo> id = null;
    private String name = null;
    private Integer version = null;
    private static final ManyToManyAFooToBarAlias manyToManyAFooToBarsAlias = new ManyToManyAFooToBarAlias("a");
    private ForeignKeyListHolder<ManyToManyAFoo, ManyToManyAFooToBar> manyToManyAFooToBars = new ForeignKeyListHolder<ManyToManyAFoo, ManyToManyAFooToBar>((ManyToManyAFoo) this, manyToManyAFooToBarsAlias, manyToManyAFooToBarsAlias.manyToManyAFoo);

    protected ManyToManyAFooCodegen() {
        this.addExtraRules();
    }

    private void addExtraRules() {
        this.addRule(new NotNull<ManyToManyAFoo>("name", Shims.name));
        this.addRule(new MaxLength<ManyToManyAFoo>("name", 100, Shims.name));
    }

    public Id<ManyToManyAFoo> getId() {
        return this.id;
    }

    public void setId(Id<ManyToManyAFoo> id) {
        this.recordIfChanged("id", this.id, id);
        this.id = id;
        if (UoW.isOpen()) {
            UoW.getCurrent().getIdentityMap().store(this);
        }
    }

    public String getName() {
        return this.name;
    }

    public void setName(java.lang.String name) {
        this.recordIfChanged("name", this.name, name);
        this.name = name;
    }

    public Integer getVersion() {
        return this.version;
    }

    public List<ManyToManyAFooToBar> getManyToManyAFooToBars() {
        return this.manyToManyAFooToBars.get();
    }

    public void addManyToManyAFooToBar(ManyToManyAFooToBar o) {
        o.setManyToManyAFooWithoutPercolation((ManyToManyAFoo) this);
        this.addManyToManyAFooToBarWithoutPercolation(o);
    }

    public void addManyToManyAFooToBarWithoutPercolation(ManyToManyAFooToBar o) {
        this.recordIfChanged("manyToManyAFooToBars");
        this.manyToManyAFooToBars.add(o);
    }

    public void removeManyToManyAFooToBar(ManyToManyAFooToBar o) {
        o.setManyToManyAFooWithoutPercolation(null);
        this.removeManyToManyAFooToBarWithoutPercolation(o);
    }

    public void removeManyToManyAFooToBarWithoutPercolation(ManyToManyAFooToBar o) {
        this.recordIfChanged("manyToManyAFooToBars");
        this.manyToManyAFooToBars.remove(o);
    }

    public List<ManyToManyABar> getManyToManyABars() {
        List<ManyToManyABar> l = new ArrayList<ManyToManyABar>();
        for (ManyToManyAFooToBar o : this.getManyToManyAFooToBars()) {
            l.add(o.getManyToManyABar());
        }
        return l;
    }

    public void addManyToManyABar(ManyToManyABar o) {
        ManyToManyAFooToBar a = new ManyToManyAFooToBar();
        a.setManyToManyAFoo((ManyToManyAFoo) this);
        a.setManyToManyABar(o);
    }

    public void removeManyToManyABar(ManyToManyABar o) {
        for (ManyToManyAFooToBar a : Copy.shallow(this.getManyToManyAFooToBars())) {
            if (a.getManyToManyABar().equals(o)) {
                a.setManyToManyABar(null);
                a.setManyToManyAFoo(null);
                UoW.getCurrent().delete(a);
            }
        }
    }

    public static class Shims {
        public static final Shim<ManyToManyAFoo, Id<ManyToManyAFoo>> id = new Shim<ManyToManyAFoo, Id<ManyToManyAFoo>>() {
            public void set(ManyToManyAFoo instance, Id<ManyToManyAFoo> id) {
                ((ManyToManyAFooCodegen) instance).id = id;
            }
            public Id<ManyToManyAFoo> get(ManyToManyAFoo instance) {
                return ((ManyToManyAFooCodegen) instance).id;
            }
        };
        public static final Shim<ManyToManyAFoo, java.lang.String> name = new Shim<ManyToManyAFoo, java.lang.String>() {
            public void set(ManyToManyAFoo instance, java.lang.String name) {
                ((ManyToManyAFooCodegen) instance).name = name;
            }
            public String get(ManyToManyAFoo instance) {
                return ((ManyToManyAFooCodegen) instance).name;
            }
        };
        public static final Shim<ManyToManyAFoo, java.lang.Integer> version = new Shim<ManyToManyAFoo, java.lang.Integer>() {
            public void set(ManyToManyAFoo instance, java.lang.Integer version) {
                ((ManyToManyAFooCodegen) instance).version = version;
            }
            public Integer get(ManyToManyAFoo instance) {
                return ((ManyToManyAFooCodegen) instance).version;
            }
        };
    }

}
