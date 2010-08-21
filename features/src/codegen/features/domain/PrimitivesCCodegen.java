package features.domain;

import com.domainlanguage.money.Money;
import com.domainlanguage.time.TimePoint;
import features.domain.queries.PrimitivesCQueries;
import joist.domain.AbstractChanged;
import joist.domain.AbstractDomainObject;
import joist.domain.Changed;
import joist.domain.Shim;
import joist.domain.uow.UoW;
import joist.domain.validation.rules.MaxLength;
import joist.domain.validation.rules.NotNull;

@SuppressWarnings("all")
public abstract class PrimitivesCCodegen extends AbstractDomainObject {

    public static final PrimitivesCQueries queries;
    private Money dollarAmount = null;
    private Integer id = null;
    private String name = null;
    private TimePoint timestamp = null;
    private Integer version = null;
    protected Changed changed;

    static {
        Aliases.init();
        queries = new PrimitivesCQueries();
    }

    protected PrimitivesCCodegen() {
        this.addExtraRules();
    }

    private void addExtraRules() {
        this.addRule(new NotNull<PrimitivesC>(Shims.dollarAmount));
        this.addRule(new NotNull<PrimitivesC>(Shims.name));
        this.addRule(new MaxLength<PrimitivesC>(Shims.name, 100));
        this.addRule(new NotNull<PrimitivesC>(Shims.timestamp));
    }

    public Money getDollarAmount() {
        return this.dollarAmount;
    }

    public void setDollarAmount(Money dollarAmount) {
        this.getChanged().record("dollarAmount", this.dollarAmount, dollarAmount);
        this.dollarAmount = dollarAmount;
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

    public TimePoint getTimestamp() {
        return this.timestamp;
    }

    public void setTimestamp(TimePoint timestamp) {
        this.getChanged().record("timestamp", this.timestamp, timestamp);
        this.timestamp = timestamp;
    }

    public Integer getVersion() {
        return this.version;
    }

    public PrimitivesCChanged getChanged() {
        if (this.changed == null) {
            this.changed = new PrimitivesCChanged((PrimitivesC) this);
        }
        return (PrimitivesCChanged) this.changed;
    }

    @Override
    public void clearAssociations() {
        super.clearAssociations();
    }

    static class Shims {
        protected static final Shim<PrimitivesC, Money> dollarAmount = new Shim<PrimitivesC, Money>() {
            public void set(PrimitivesC instance, Money dollarAmount) {
                ((PrimitivesCCodegen) instance).dollarAmount = dollarAmount;
            }
            public Money get(PrimitivesC instance) {
                return ((PrimitivesCCodegen) instance).dollarAmount;
            }
            public String getName() {
                return "dollarAmount";
            }
        };
        protected static final Shim<PrimitivesC, Integer> id = new Shim<PrimitivesC, Integer>() {
            public void set(PrimitivesC instance, Integer id) {
                ((PrimitivesCCodegen) instance).id = id;
            }
            public Integer get(PrimitivesC instance) {
                return ((PrimitivesCCodegen) instance).id;
            }
            public String getName() {
                return "id";
            }
        };
        protected static final Shim<PrimitivesC, String> name = new Shim<PrimitivesC, String>() {
            public void set(PrimitivesC instance, String name) {
                ((PrimitivesCCodegen) instance).name = name;
            }
            public String get(PrimitivesC instance) {
                return ((PrimitivesCCodegen) instance).name;
            }
            public String getName() {
                return "name";
            }
        };
        protected static final Shim<PrimitivesC, TimePoint> timestamp = new Shim<PrimitivesC, TimePoint>() {
            public void set(PrimitivesC instance, TimePoint timestamp) {
                ((PrimitivesCCodegen) instance).timestamp = timestamp;
            }
            public TimePoint get(PrimitivesC instance) {
                return ((PrimitivesCCodegen) instance).timestamp;
            }
            public String getName() {
                return "timestamp";
            }
        };
        protected static final Shim<PrimitivesC, Integer> version = new Shim<PrimitivesC, Integer>() {
            public void set(PrimitivesC instance, Integer version) {
                ((PrimitivesCCodegen) instance).version = version;
            }
            public Integer get(PrimitivesC instance) {
                return ((PrimitivesCCodegen) instance).version;
            }
            public String getName() {
                return "version";
            }
        };
    }

    public static class PrimitivesCChanged extends AbstractChanged {
        public PrimitivesCChanged(PrimitivesC instance) {
            super(instance);
        }
        public boolean hasDollarAmount() {
            return this.contains("dollarAmount");
        }
        public Money getOriginalDollarAmount() {
            return (com.domainlanguage.money.Money) this.getOriginal("dollarAmount");
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
        public boolean hasTimestamp() {
            return this.contains("timestamp");
        }
        public TimePoint getOriginalTimestamp() {
            return (com.domainlanguage.time.TimePoint) this.getOriginal("timestamp");
        }
        public boolean hasVersion() {
            return this.contains("version");
        }
        public Integer getOriginalVersion() {
            return (java.lang.Integer) this.getOriginal("version");
        }
    }

}
