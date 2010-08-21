package features.domain;

import features.domain.queries.ManyToManyBFooToBarQueries;
import joist.domain.AbstractChanged;
import joist.domain.AbstractDomainObject;
import joist.domain.Changed;
import joist.domain.Shim;
import joist.domain.orm.ForeignKeyHolder;
import joist.domain.uow.UoW;
import joist.domain.validation.rules.NotNull;

@SuppressWarnings("all")
public abstract class ManyToManyBFooToBarCodegen extends AbstractDomainObject {

    public static final ManyToManyBFooToBarQueries queries;
    private Integer id = null;
    private Integer version = null;
    private final ForeignKeyHolder<ManyToManyBFoo> blue = new ForeignKeyHolder<ManyToManyBFoo>(ManyToManyBFoo.class);
    private final ForeignKeyHolder<ManyToManyBBar> green = new ForeignKeyHolder<ManyToManyBBar>(ManyToManyBBar.class);
    protected Changed changed;

    static {
        Aliases.init();
        queries = new ManyToManyBFooToBarQueries();
    }

    protected ManyToManyBFooToBarCodegen() {
        this.addExtraRules();
    }

    private void addExtraRules() {
        this.addRule(new NotNull<ManyToManyBFooToBar>(Shims.blueId));
        this.addRule(new NotNull<ManyToManyBFooToBar>(Shims.greenId));
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

    public Integer getVersion() {
        return this.version;
    }

    public ManyToManyBFoo getBlue() {
        return this.blue.get();
    }

    public void setBlue(ManyToManyBFoo blue) {
        if (this.blue.get() != null) {
           this.blue.get().removeBlueManyToManyBFooToBarWithoutPercolation((ManyToManyBFooToBar) this);
        }
        this.setBlueWithoutPercolation(blue);
        if (this.blue.get() != null) {
           this.blue.get().addBlueManyToManyBFooToBarWithoutPercolation((ManyToManyBFooToBar) this);
        }
    }

    protected void setBlueWithoutPercolation(ManyToManyBFoo blue) {
        this.getChanged().record("blue", this.blue, blue);
        this.blue.set(blue);
    }

    public ManyToManyBBar getGreen() {
        return this.green.get();
    }

    public void setGreen(ManyToManyBBar green) {
        if (this.green.get() != null) {
           this.green.get().removeGreenManyToManyBFooToBarWithoutPercolation((ManyToManyBFooToBar) this);
        }
        this.setGreenWithoutPercolation(green);
        if (this.green.get() != null) {
           this.green.get().addGreenManyToManyBFooToBarWithoutPercolation((ManyToManyBFooToBar) this);
        }
    }

    protected void setGreenWithoutPercolation(ManyToManyBBar green) {
        this.getChanged().record("green", this.green, green);
        this.green.set(green);
    }

    public ManyToManyBFooToBarChanged getChanged() {
        if (this.changed == null) {
            this.changed = new ManyToManyBFooToBarChanged((ManyToManyBFooToBar) this);
        }
        return (ManyToManyBFooToBarChanged) this.changed;
    }

    @Override
    public void clearAssociations() {
        super.clearAssociations();
        this.setBlue(null);
        this.setGreen(null);
    }

    static class Shims {
        protected static final Shim<ManyToManyBFooToBar, Integer> id = new Shim<ManyToManyBFooToBar, Integer>() {
            public void set(ManyToManyBFooToBar instance, Integer id) {
                ((ManyToManyBFooToBarCodegen) instance).id = id;
            }
            public Integer get(ManyToManyBFooToBar instance) {
                return ((ManyToManyBFooToBarCodegen) instance).id;
            }
            public String getName() {
                return "id";
            }
        };
        protected static final Shim<ManyToManyBFooToBar, Integer> version = new Shim<ManyToManyBFooToBar, Integer>() {
            public void set(ManyToManyBFooToBar instance, Integer version) {
                ((ManyToManyBFooToBarCodegen) instance).version = version;
            }
            public Integer get(ManyToManyBFooToBar instance) {
                return ((ManyToManyBFooToBarCodegen) instance).version;
            }
            public String getName() {
                return "version";
            }
        };
        protected static final Shim<ManyToManyBFooToBar, Integer> blueId = new Shim<ManyToManyBFooToBar, Integer>() {
            public void set(ManyToManyBFooToBar instance, Integer blueId) {
                ((ManyToManyBFooToBarCodegen) instance).blue.setId(blueId);
            }
            public Integer get(ManyToManyBFooToBar instance) {
                return ((ManyToManyBFooToBarCodegen) instance).blue.getId();
            }
            public String getName() {
                return "blue";
            }
        };
        protected static final Shim<ManyToManyBFooToBar, Integer> greenId = new Shim<ManyToManyBFooToBar, Integer>() {
            public void set(ManyToManyBFooToBar instance, Integer greenId) {
                ((ManyToManyBFooToBarCodegen) instance).green.setId(greenId);
            }
            public Integer get(ManyToManyBFooToBar instance) {
                return ((ManyToManyBFooToBarCodegen) instance).green.getId();
            }
            public String getName() {
                return "green";
            }
        };
    }

    public static class ManyToManyBFooToBarChanged extends AbstractChanged {
        public ManyToManyBFooToBarChanged(ManyToManyBFooToBar instance) {
            super(instance);
        }
        public boolean hasId() {
            return this.contains("id");
        }
        public Integer getOriginalId() {
            return (java.lang.Integer) this.getOriginal("id");
        }
        public boolean hasVersion() {
            return this.contains("version");
        }
        public Integer getOriginalVersion() {
            return (java.lang.Integer) this.getOriginal("version");
        }
        public boolean hasBlue() {
            return this.contains("blue");
        }
        public ManyToManyBFoo getOriginalBlue() {
            return (ManyToManyBFoo) this.getOriginal("blue");
        }
        public boolean hasGreen() {
            return this.contains("green");
        }
        public ManyToManyBBar getOriginalGreen() {
            return (ManyToManyBBar) this.getOriginal("green");
        }
    }

}
