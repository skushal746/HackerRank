package testing;

import java.util.Collection;
import java.util.stream.Collectors;

public class Orders {
	
	Collection<Item> removeDuplicates(Collection<Item> items)
	{ 
		return items.stream().distinct().collect(Collectors.toSet());
	}
	
}
