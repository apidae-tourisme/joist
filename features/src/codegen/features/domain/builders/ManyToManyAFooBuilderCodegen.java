package features.domain.builders;

import features.domain.ManyToManyAFoo;
import joist.domain.builders.AbstractBuilder;

@SuppressWarnings("all")
public abstract class ManyToManyAFooBuilderCodegen extends AbstractBuilder<ManyToManyAFoo> {

    public ManyToManyAFooBuilderCodegen(ManyToManyAFoo instance) {
        super(instance);
    }

    public ManyToManyAFooBuilder id(Integer id) {
        get().setId(id);
        return (ManyToManyAFooBuilder) this;
    }

    public ManyToManyAFooBuilder name(String name) {
        get().setName(name);
        return (ManyToManyAFooBuilder) this;
    }

    public ManyToManyAFoo get() {
        return (features.domain.ManyToManyAFoo) super.get();
    }

}
