package lgarcia.dev.nutrigest_api.services;

import lgarcia.dev.nutrigest_api.models.CategoryModel;
import lgarcia.dev.nutrigest_api.repositories.ICategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class CategoryService {

    @Autowired
    ICategoryRepository categoryRepository;

    //Obtener lista de categorias
    public ArrayList<CategoryModel> getCategories() {
        return (ArrayList<CategoryModel>) categoryRepository.findAll();
    }

    //Obtener una categoria por su id
    public CategoryModel getCategoryById(Long id) {
        return categoryRepository.findById(id).orElse(null);
    }

    //Crear una categoria
    public CategoryModel storeCategory(CategoryModel category) {
        return categoryRepository.save(category);
    }

    //Actualizar una categoria
    public CategoryModel updateCategory(CategoryModel category, Long id) {
        CategoryModel categoryToUpdate = categoryRepository.findById(id).orElse(null);

        if (categoryToUpdate != null) {
            if (category.getName() != null) {
                categoryToUpdate.setName(category.getName());
            }

            return categoryRepository.save(categoryToUpdate);
        }
        return null;
    }

    //Eliminar una categoria
    public void deleteCategory(Long id) {
        categoryRepository.deleteById(id);
    }
}
