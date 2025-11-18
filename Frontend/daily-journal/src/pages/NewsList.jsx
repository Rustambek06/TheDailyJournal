import { useEffect, useState } from "react";
import { NewsService } from "../services/newsService";
import { CategoryService } from "../services/categoryService";
import { UserService } from "../services/userService";

function NewsList() {
  const [news, setNews] = useState([]);
  const [categories, setCategories] = useState([]);
  const [users, setUsers] = useState([]);
  const [newNews, setNewNews] = useState({
    title: "",
    content: "",
    categoryId: "",
    userId: "",
  });

  // Загружаем все данные при первом рендере
  useEffect(() => {
    loadNews();
    loadCategories();
    loadUsers();
  }, []);

  const loadNews = async () => {
    try {
      const data = await NewsService.getAll();
      setNews(data);
    } catch (err) {
      console.error("Ошибка при загрузке новостей:", err);
    }
  };

  const loadCategories = async () => {
    try {
      const data = await CategoryService.getAll();
      setCategories(data);
    } catch (err) {
      console.error("Ошибка при загрузке категорий:", err);
    }
  };

  const loadUsers = async () => {
    try {
      const data = await UserService.getAll();
      setUsers(data);
    } catch (err) {
      console.error("Ошибка при загрузке пользователей:", err);
    }
  };

  const handleAddNews = async (e) => {
    e.preventDefault();

    if (!newNews.title || !newNews.content || !newNews.categoryId || !newNews.userId) {
      alert("Заполни все поля перед добавлением новости!");
      return;
    }

    try {
      await NewsService.create({
        title: newNews.title,
        content: newNews.content,
        categoryId: Number(newNews.categoryId),
        userId: Number(newNews.userId),
      });
      setNewNews({ title: "", content: "", categoryId: "", userId: "" });
      loadNews();
    } catch (err) {
      console.error("Ошибка при добавлении новости:", err);
    }
  };

  const handleDelete = async (id) => {
    if (window.confirm("Удалить эту новость?")) {
      await NewsService.delete(id);
      setNews((prev) => prev.filter((n) => n.id !== id));
    }
  };

  return (
    <div style={{ padding: "20px" }}>
      <h2>Новости</h2>

      {/* ======== ФОРМА ДОБАВЛЕНИЯ ======== */}
      <form
        onSubmit={handleAddNews}
        style={{
          display: "flex",
          flexDirection: "column",
          gap: "8px",
          maxWidth: "400px",
          marginBottom: "20px",
        }}
      >
        <input
          type="text"
          placeholder="Заголовок"
          value={newNews.title}
          onChange={(e) => setNewNews({ ...newNews, title: e.target.value })}
        />
        <textarea
          placeholder="Контент"
          rows={3}
          value={newNews.content}
          onChange={(e) => setNewNews({ ...newNews, content: e.target.value })}
        />

        <select
          value={newNews.categoryId}
          onChange={(e) => setNewNews({ ...newNews, categoryId: e.target.value })}
        >
          <option value="">Выбери категорию</option>
          {categories.map((cat) => (
            <option key={cat.id} value={cat.id}>
              {cat.name}
            </option>
          ))}
        </select>

        <select
          value={newNews.userId}
          onChange={(e) => setNewNews({ ...newNews, userId: e.target.value })}
        >
          <option value="">Выбери пользователя</option>
          {users.map((u) => (
            <option key={u.id} value={u.id}>
              {u.username}
            </option>
          ))}
        </select>

        <button type="submit">Добавить новость</button>
      </form>

      {/* ======== СПИСОК НОВОСТЕЙ ======== */}
      <ul style={{ listStyle: "none", padding: 0 }}>
        {news.map((item) => (
          <li
            key={item.id}
            style={{
              border: "1px solid #ddd",
              borderRadius: "8px",
              padding: "10px",
              marginBottom: "10px",
            }}
          >
            <h3>{item.title}</h3>
            <p>{item.content}</p>
            <p>
              <strong>Категория:</strong> {item.categoryName || "—"}  
              {" | "}
              <strong>Автор:</strong> {item.username || "—"}  
              {" | "}
              <strong>Дата:</strong> {new Date(item.createdAt).toLocaleString()}
            </p>
            <button onClick={() => handleDelete(item.id)}>Удалить</button>
          </li>
        ))}
      </ul>
    </div>
  );
}

export default NewsList;