package it.unibz.internet.domain;

public class DishRating {
	Dish dish;
	int rating;

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
	public int getRating() {
		return rating;
	}

	/**
	 * @param rating
	 *            the rating to set
	 */
	public void setRating(int rating) {
		this.rating = rating;
	}

	/**
	 * Constructor
	 * @param dish
	 * @param rating
	 */
	public DishRating(Dish dish, int rating) {
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