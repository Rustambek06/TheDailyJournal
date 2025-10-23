import { useEffect, useState } from "react";

function NewsList() {
    const [news, setNews] = useState();

    useEffect(() => {
        fetch("http://localhost:8080/api/news")
        .then((res) => res.json())
        .then((data) => setNews(data))
        .catch((err) => console.error("Ошибка загрузки новостей: ", err));
    }, []);

    return (
        <div style={{ padding: "20px"}}>
            <h2>Новости</h2>
            <ul>
                {news.map((item) => (
                    <li key={item.id}>
                        <strong>{item.title}</strong> - {item.category.name}
                        <p>{item.content}</p>
                    </li>
                ))}
            </ul>
        </div>
    );
} 

export default NewsList;