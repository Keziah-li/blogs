package com.example.controller;

import com.example.Constants;
import com.example.model.MyModel;
import com.canoo.platform.server.DolphinAction;
import com.canoo.platform.server.DolphinController;
import com.canoo.platform.server.DolphinModel;
import javax.annotation.PostConstruct;

/**
 * This class defines the controller. Whenever a matching view is created in a client a controller instance will be
 * created on the server. The controller is completelly managed by the container and therefore features like CDI can
 * be used without any problems in the controller.
 * The {@link DolphinController} annotation defines the unique name of this controller type. In this sample a static
 * constant is used for the name that is shared with the JavaFX client.
 */
@DolphinController(Constants.CONTROLLER_NAME)
public class MyController {

    /**
     * Defines the model of the MVC group. Like the controller this model will automatically be managed by the container
     * and before the init() method (annotated with {@link PostConstruct}) is called the model will be injected in the
     * controller.
     */
    @DolphinModel
    private MyModel model;

    /**
     * Like in any managed bean this method will be called once the initalisation of the instance (injection etc.) is done.
     */
    @PostConstruct
    public void init() {
        // An observer is added to the value property of the model. Since the model will automatically be synchronized
        // between client and server the observer will be called whenever the model changes on the client. When having
        // a look a the client implementation you will see that the value property is bound to an input field. By doing
        // so the observer that is defined here will automatically be called when the user types text in the input on the client
        model.valueProperty().onChanged(e -> System.out.println("VALUE CHANGED FROM " + e.getOldValue() + " TO " + e.getNewValue()));
    }

    /**
     * By adding the {@link DolphinAction} annotation to a method this method can be triggered as a controller action on
     * the client. To do so the client must trigger the action based on its name. As long as no value is defined for the
     * annotation the method name will be used. This means that this method can be triggered by calling a "reset" action
     * on the client.
     */
    @DolphinAction(Constants.RESET_ACTION)
    public void reset() {
        model.setValue(null);
    }
}
