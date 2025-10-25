import { useEffect, useState } from "react";
import { CategoryService } from "../services/categoryService";

function CategoryList() {
    const [categories, setCategories] = useState([]);
    const [newCategory, setNewCategory] = useState({name: ""});

    useEffect(() => {
        loadCategories();
    }, [categories]);

    const loadCategories = async () => {
        try {
            const data = await CategoryService.getAll();
            setCategories(data);
        } catch (err) {
            console.error("Ошибка загрузки категорий:", err);
        }
    };

    const handleAdd = async (e) => {
        e.preventDefault();
        if(!newCategory.name) return;
        await CategoryService.create(newCategory);
        setNewCategory({name: ""});
        loadCategories();
    }

    const handleDelete = async (id) => {
        await CategoryService.delete(id);
        loadCategories();
    }

    return (
        <div style={{padding: "20px"}}>
            <form onSubmit={handleAdd} style={{marginBottom: "15px"}}>
                <input 
                    type="text"
                    placeholder="Название категории"
                    value={newCategory.name}
                    onChange={(e) => setNewCategory({...newCategory, name: e.target.value})}
                />
                <button type="submit">Добавить</button>
            </form>
            <ul>
                {categories.map((c) => (
                    <li key={c.id}>
                        {c.name}
                        <button onClick={() => handleDelete(c.id)}>Удалить</button>
                    </li>
                ))}
            </ul>            
        </div>
    )
}

export default CategoryList;