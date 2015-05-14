package it.unibz.internet.domain;

/**
 * Order Detail entry - Dish with rating
 * @author Werner Frei <freiwe@gmail.com>
 *
 */
public class DishRating {
	Dish dish;
	double rating;

	/**
	 * @return the dish
	 */
	public Dish getDish() {
		return dish;
	}

	/**
	 * @param dish
	 *            the dish to set
	 */
	public void setDish(Dish dish) {
		this.dish = dish;
	}

	/**
	 * @return the rating
	 */
	public double getRating() {
		return rating;
	}

	/**
	 * @param rating
	 *            the rating to set
	 */
	public void setRating(double rating) {
		this.rating = rating;
	}

	/**
	 * Constructor
	 * @param dish
	 * @param rating
	 */
	public DishRating(Dish dish, double rating) {
		this.dish = dish;
		this.rating=rating;
	}
	
    @Override
    public boolean equals(Object o) {
        if (!(o instanceof DishRating)) {
            return false;
        } else {
            DishRating tmpdishrating = (DishRating) o;
            boolean result = this.getDish().equals(tmpdishrating.getDish());
            result = result && this.rating==tmpdishrating.rating;
            return result;
        }
    }
}