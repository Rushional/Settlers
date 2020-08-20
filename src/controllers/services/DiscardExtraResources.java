package controllers.services;

import models.Player;
import models.ResourcesSet;
import views.frame.SettlersFrame;
import views.dialogs.RequestResourcesToDiscard;
import views.services.ShowPlayersResources;

/*
* But now this check happens on view and I'm not sure if it needs to be changed
* In theory, having some stuff happen in View isn't a good idea, and it kinda violates MVC
* So I proooobably ought to change it so that DiscardResourcesDialog only gets input,
* And the controller makes the decision, while the dialog just waits
* This means that we need to make dialog wait for controller to check the input.
* Currently it can't be easily done, because modal dialog blocks Event Dispatch Tread
* That can be changed in two ways I can think of.
* First: instead of making it modal, I can make it non-modal, and frame.setEnabled(false) the parent
* frame when I show the dialog. I don't know how to do it easily. I tried it and the dialog disappears immediately.
* Second: I can start a new thread where the controller will check the input while the dialog is doing it's thing
* I think the better option would be to solve it using threads, because learning dialogs and Swing is kinda useless,
* but more practice with threads never hurts.
*
* For now though I'm leaving it as it is. I don't want to bother and would rather do something else.
* TODO: make controller check dialog input, because now the dialog does it itself, and that could be bad
*/
public class DiscardExtraResources {
    public static void call(Player player, SettlersFrame frame) {
        System.out.println("FBI! OPEN UP!");
        System.out.println(player.getColor() + " player, у вас обнаружили партию ЗАПРЕЩЁННЫХ ВЕЩЕСТВ!!!");
        ShowPlayersResources.call(player);
        System.out.println("Выберите, какие ЗАПРЕЩЁННЫЕ ВЕЩЕСТВА будут КОНФИСКОВАНЫ");
        ResourcesSet discardSet = RequestResourcesToDiscard.call(frame, player.getResources());
        System.out.println("Поздравляем, ваши ВЕЩЕСТВА были успешно КОНФИСКОВАНЫ!");
        System.out.println("Конфискованные вещества: " + discardSet.toString());
        player.subtractResources(discardSet);
        ShowPlayersResources.call(player);
    }
}
