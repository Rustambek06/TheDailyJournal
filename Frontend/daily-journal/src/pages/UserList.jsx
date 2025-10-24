import { useEffect, useState } from "react";
import { UserService } from "../services/userService";

function UserList() {
    const [users, setUsers] = useState([]);
    const [newUser, setNewUser] = useState({ username: "", email: ""});

    useEffect (() => {
        loadUsers();
    }, []);

    const loadUsers = async () => {
        try {
            const data = await UserService.getAll();
            setUsers(data);
        } catch (err) {
            console.error("Ошибка загрузки пользователей:", error);
        }
    };

    const handleAdd = async (e) => {
        e.preventDefault();
        if(!newUser.username || !newUser.email) return;
        await UserService.create(newUser);
        setNewUser({username: "", email: ""});
        loadUsers();
    };

    const handleDelete = async (id) => {
        await UserService.delete(id);
        loadUsers();
    }

    return (
        <div style={{ padding: "20px"}}>
            <form onSubmit={handleAdd} style={{marginBottom: "15px"}}>
                <input
                    type="text"
                    placeholder="Имя пользователя"
                    value={newUser.username}
                    onChange={(e) => setNewUser({...newUser, username: e.target.value})}
                />
                <input
                    type="email"
                    placeholder="Email"
                    value={newUser.email}
                    onChange={(e) => setNewUser({ ...newUser, email: e.target.value})}
                />
                <button type="submit">Добавить</button>
            </form>
        
        <ul>
            {users.map((u) => (
                <li key={u.id}>
                    {u.username} ({u.email})
                    <button onClick={() => handleDelete(u.id)}>Удалить</button>
                </li>
            ))}
        </ul>
        </div>
    )
}

export default UserList;