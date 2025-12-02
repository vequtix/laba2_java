package Main;

import MVC.Controller;
import MVC.Model.*;
import MVC.View;

import java.util.List;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        List<BaseCocktail> cocktails = new ArrayList<>();

        cocktails.add(new ClassicCocktail("Негрони", List.of(
                new CocktailStep(Action.POUR, new AlcoIngredient("Джин", 30, 40)),
                new CocktailStep(Action.ADD, new AlcoIngredient("Кампари", 30, 25)),
                new CocktailStep(Action.ADD, new AlcoIngredient("Сладкий вермут", 30, 16))
        )));

        cocktails.add(new ClassicCocktail("Мохито", List.of(
                new CocktailStep(Action.POUR, new AlcoIngredient("Белый ром", 50, 40)),
                new CocktailStep(Action.ADD, new NonAlcoIngredient("Сок лайма", 25)),
                new CocktailStep(Action.ADD, new NonAlcoIngredient("Содовая", 100))
        )));

        View view = new View();

        for (BaseCocktail cocktail : cocktails) {
            Controller controller = new Controller(cocktail, view);
            controller.prepareCocktail();
        }
    }
}
