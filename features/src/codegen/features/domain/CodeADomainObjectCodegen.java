package features.domain;

import features.domain.queries.CodeADomainObjectQueries;
import joist.domain.AbstractChanged;
import joist.domain.AbstractDomainObject;
import joist.domain.Changed;
import joist.domain.Shim;
import joist.domain.orm.ForeignKeyCodeHolder;
import joist.domain.uow.UoW;
import joist.domain.validation.rules.MaxLength;
import joist.domain.validation.rules.NotNull;

public abstract class CodeADomainObjectCodegen extends AbstractDomainObject {

    public static final CodeADomainObjectQueries queries;
    private Integer id = null;
    private String name = null;
    private Integer version = null;
    private final ForeignKeyCodeHolder<CodeAColor> codeAColor = new ForeignKeyCodeHolder<CodeAColor>(CodeAColor.class);
    private final ForeignKeyCodeHolder<CodeASize> codeASize = new ForeignKeyCodeHolder<CodeASize>(CodeASize.class);
    protected Changed changed;

    static {
        Aliases.init();
        queries = new CodeADomainObjectQueries();
    }

    protected CodeADomainObjectCodegen() {
        this.addExtraRules();
    }

    private void addExtraRules() {
        this.addRule(new NotNull<CodeADomainObject>(Shims.name));
        this.addRule(new MaxLength<CodeADomainObject>(Shims.name, 100));
        this.addRule(new NotNull<CodeADomainObject>(Shims.codeAColorId));
        this.addRule(new NotNull<CodeADomainObject>(Shims.codeASizeId));
    }

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.getChanged().record("id", this.id, id);
        this.id = id;
        if (UoW.isOpen()) {
            UoW.getIdentityMap().store(this);
        }
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.getChanged().record("name", this.name, name);
        this.name = name;
    }

    public Integer getVersion() {
        return this.version;
    }

    public CodeAColor getCodeAColor() {
        return this.codeAColor.get();
    }

    public void setCodeAColor(CodeAColor codeAColor) {
        this.setCodeAColorWithoutPercolation(codeAColor);
    }

    protected void setCodeAColorWithoutPercolation(CodeAColor codeAColor) {
        this.getChanged().record("codeAColor", this.codeAColor, codeAColor);
        this.codeAColor.set(codeAColor);
    }

    public boolean isBlue() {
        return getCodeAColor() == CodeAColor.BLUE;
    }

    public boolean isGreen() {
        return getCodeAColor() == CodeAColor.GREEN;
    }

    public CodeASize getCodeASize() {
        return this.codeASize.get();
    }

    public void setCodeASize(CodeASize codeASize) {
        this.setCodeASizeWithoutPercolation(codeASize);
    }

    protected void setCodeASizeWithoutPercolation(CodeASize codeASize) {
        this.getChanged().record("codeASize", this.codeASize, codeASize);
        this.codeASize.set(codeASize);
    }

    public boolean isOne() {
        return getCodeASize() == CodeASize.ONE;
    }

    public boolean isTwo() {
        return getCodeASize() == CodeASize.TWO;
    }

    public CodeADomainObjectChanged getChanged() {
        if (this.changed == null) {
            this.changed = new CodeADomainObjectChanged((CodeADomainObject) this);
        }
        return (CodeADomainObjectChanged) this.changed;
    }

    @Override
    public void clearAssociations() {
        super.clearAssociations();
        this.setCodeAColor(null);
        this.setCodeASize(null);
    }

    static class Shims {
        protected static final Shim<CodeADomainObject, Integer> id = new Shim<CodeADomainObject, Integer>() {
            public void set(CodeADomainObject instance, Integer id) {
                ((CodeADomainObjectCodegen) instance).id = id;
            }
            public Integer get(CodeADomainObject instance) {
                return ((CodeADomainObjectCodegen) instance).id;
            }
            public String getName() {
                return "id";
            }
        };
        protected static final Shim<CodeADomainObject, String> name = new Shim<CodeADomainObject, String>() {
            public void set(CodeADomainObject instance, String name) {
                ((CodeADomainObjectCodegen) instance).name = name;
            }
            public String get(CodeADomainObject instance) {
                return ((CodeADomainObjectCodegen) instance).name;
            }
            public String getName() {
                return "name";
            }
        };
        protected static final Shim<CodeADomainObject, Integer> version = new Shim<CodeADomainObject, Integer>() {
            public void set(CodeADomainObject instance, Integer version) {
                ((CodeADomainObjectCodegen) instance).version = version;
            }
            public Integer get(CodeADomainObject instance) {
                return ((CodeADomainObjectCodegen) instance).version;
            }
            public String getName() {
                return "version";
            }
        };
        protected static final Shim<CodeADomainObject, Integer> codeAColorId = new Shim<CodeADomainObject, Integer>() {
            public void set(CodeADomainObject instance, Integer codeAColorId) {
                ((CodeADomainObjectCodegen) instance).codeAColor.setId(codeAColorId);
            }
            public Integer get(CodeADomainObject instance) {
                return ((CodeADomainObjectCodegen) instance).codeAColor.getId();
            }
            public String getName() {
                return "codeAColor";
            }
        };
        protected static final Shim<CodeADomainObject, Integer> codeASizeId = new Shim<CodeADomainObject, Integer>() {
            public void set(CodeADomainObject instance, Integer codeASizeId) {
                ((CodeADomainObjectCodegen) instance).codeASize.setId(codeASizeId);
            }
            public Integer get(CodeADomainObject instance) {
                return ((CodeADomainObjectCodegen) instance).codeASize.getId();
            }
            public String getName() {
                return "codeASize";
            }
        };
    }

    public static class CodeADomainObjectChanged extends AbstractChanged {
        public CodeADomainObjectChanged(CodeADomainObject instance) {
            super(instance);
        }
        public boolean hasId() {
            return this.contains("id");
        }
        public Integer getOriginalId() {
            return (java.lang.Integer) this.getOriginal("id");
        }
        public boolean hasName() {
            return this.contains("name");
        }
        public String getOriginalName() {
            return (java.lang.String) this.getOriginal("name");
        }
        public boolean hasVersion() {
            return this.contains("version");
        }
        public Integer getOriginalVersion() {
            return (java.lang.Integer) this.getOriginal("version");
        }
        public boolean hasCodeAColor() {
            return this.contains("codeAColor");
        }
        public CodeAColor getOriginalCodeAColor() {
            return (CodeAColor) this.getOriginal("codeAColor");
        }
        public boolean hasCodeASize() {
            return this.contains("codeASize");
        }
        public CodeASize getOriginalCodeASize() {
            return (CodeASize) this.getOriginal("codeASize");
        }
    }

}
