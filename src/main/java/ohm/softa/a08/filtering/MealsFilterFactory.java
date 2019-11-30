package ohm.softa.a08.filtering;

import java.util.HashMap;
import java.util.Map;

abstract public class MealsFilterFactory {
	private static final Map<String, MealsFilter> filters = new HashMap<>();

	static{
		filters.put("All", new NoFilter());
		filters.put("Vegetarian", new CategoryFilter(true, new String[] {"vegetarisch","vegan"}));
		filters.put("No pork", new CategoryFilter(false, new String[] {"schwein"}));
		filters.put("No soy", new NotesFilter("soja"));
	}

	public static MealsFilter getStrategy(String key) {
		return filters.getOrDefault(key, filters.get("All"));
	}

	public static MealsFilter getStrategyThroughSwitch(String key) {
		switch (key) {
			case "Vegetarian":
				return new CategoryFilter(true, new String[] {"vegetarisch","vegan"});
			case "No soy":
				return new NotesFilter("soja");
			case "No pork":
				return new CategoryFilter(false, new String[] {"schwein"});
			default:
				return new NoFilter();
		}
	}

	private MealsFilterFactory(){

	}


}
