import { useEffect, useState } from "react";
import { loadNews } from ""

function Main() {
    useEffect(() => {
        
    })

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
}