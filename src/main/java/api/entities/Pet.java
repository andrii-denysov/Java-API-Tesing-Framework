package api.entities;

import java.util.List;
import java.util.Map;

public record Pet(Integer id, Category category, String name, Map<String, String> photoUrls, List<Tag> tags,
                  PetStatus petStatus) {

}
