import { useEffect, useState } from "react";

function CategoryList() {
    const [categories, setCategories] = useState([]);

    useEffect(() => {
        fetch("http://localhost:8080/api/categories")
        .then((res) => res.json())
        .then((data) => setCategories(data))
        .catch((err) => console.error("Ошибка загрузки категорий: ", err));
    }, []);

    return (
        <div style={{padding: "20px"}}>
            <h2>категории</h2>
            <ul>
                {categories.map((cat) => (
                    <li key={cat.id}>{cat.name}</li>
                ))}
            </ul>
        </div>
    );
}

export default CategoryList;