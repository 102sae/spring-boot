package com.example.springbootlecture.ioc;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class Chef {
    private final  IngredientFactory ingredientFactory;
    public String cook(String menu)
    {
     //재료 준비
    Ingredient ingredient = ingredientFactory.getIngredient(menu);

    // 뚝딱뚝딱...

        return ingredient.getName() + "으로 만든 " + menu;
    }

}
