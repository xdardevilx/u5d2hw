package com.epicode.U5D2;

import com.epicode.U5D2.entities.Drink;
import com.epicode.U5D2.entities.Pizza;
import com.epicode.U5D2.entities.Topping;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class Esercizio30102023ApplicationTests {

	@Autowired
	private List<Pizza> pizzas;
	@Autowired
	private List<Drink> drinks;

	@Autowired
	private List<Topping> toppings;


	@Test
	void contextLoads() {
		System.out.println("prova l'app");
	}

	@Test
	void testPizzaExist() {
		System.out.println("controlla l'array di pizze e dimmi se c'è la salami");
		boolean salamiPizzaExist = false;
		for (Pizza pizza : pizzas) {
			if(pizza.getName().equalsIgnoreCase("salami pizza")){
				salamiPizzaExist = true;
				break;
			}
		}
			assertTrue(salamiPizzaExist);
	}

	@Test
	void testPriceDrink(){
		System.out.println("controlla il prezzo del vino");
		boolean wineExist = false;
		double priceWine= 7.49;
        for (Drink drink : drinks) {
            if (drink.getPrice() == priceWine) {
                wineExist = true;
                break;
            }
        }
        assertTrue(wineExist, "il prezzo del vino è quello comparato");
	}

	@Test
	void testAllcondiments(){
		System.out.println("controlla che ci siano tutti i condimenti");
			int allCondiments = 0;
		for (Topping topping : toppings) {
			if(topping.getName().equalsIgnoreCase("tomato") ||
					topping.getName().equalsIgnoreCase("Cheese")||
					topping.getName().equalsIgnoreCase("Ham")||
					topping.getName().equalsIgnoreCase("Pineapple")||
					topping.getName().equalsIgnoreCase("Salami")){
					allCondiments++;
			}
		}
			assertEquals(5, allCondiments);
	}


	@ParameterizedTest
	@CsvSource({
			"Lemonade, Water, Wine",
			"Pizza Margherita, Hawaiian Pizza, Salami Pizza, Salami Pizza XL",
			"Tomato, Cheese, Ham, Pineapple, Salami"
	})
	void testMultiParameter(){
		System.out.println("controlla più parametri contemporaneamente");

		boolean hasDrinks = false;
		boolean hasPizzas = false;
		boolean hasToppings = false;

		for(Drink drink : drinks){
			if(drink.getName().equalsIgnoreCase("lemonade")){
				hasDrinks = true;
				break;
			}
		}

		for(Pizza pizza : pizzas){
			if (pizza.getName().equalsIgnoreCase("pizza margherita")){
				hasPizzas = true;
				break;
			}
		}
		for(Topping topping : toppings){
			if(topping.getName().equalsIgnoreCase("tomato")){
				hasToppings = true;
				break;
			}
		}

		assertTrue(hasDrinks && hasPizzas && hasToppings);
	}

}
