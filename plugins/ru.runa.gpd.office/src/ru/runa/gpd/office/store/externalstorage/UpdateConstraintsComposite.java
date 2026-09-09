package ru.runa.gpd.office.store.externalstorage;

import java.util.function.Predicate;
import org.eclipse.swt.widgets.Composite;
import ru.runa.gpd.lang.model.Variable;
import ru.runa.gpd.office.Messages;
import ru.runa.gpd.office.store.StorageConstraintsModel;
import ru.runa.wfe.var.UserTypeMap;

public class UpdateConstraintsComposite extends AbstractOperatingVariableComboBasedConstraintsCompositeBuilder {
    public UpdateConstraintsComposite(Composite parent, int style, StorageConstraintsModel constraintsModel, VariableProvider variableProvider,
            String variableTypeName) {
        super(parent, style, constraintsModel, variableProvider, variableTypeName);
    }

    @Override
    protected Predicate<? super Variable> getFilterPredicate(String variableTypeName) {
        return variable -> variable.isComplex() && variable.getUserType().getName().equals(variableTypeName);
    }

    @Override
    protected String[] getTypeNameFilters() {
        return new String[] { UserTypeMap.class.getName() };
    }

    @Override
    protected String getComboTitle() {
        return Messages.getString("label.UpdateVariable");
    }

}
