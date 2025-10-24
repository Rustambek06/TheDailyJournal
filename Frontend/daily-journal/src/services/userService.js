import { apiRequest } from "./api";

export const UserService = {
    getAll: () => apiRequest("/users"),
    create: (data) => apiRequest("/users", "POST", data),
    delete: (id) => apiRequest(`/users/${id}`, "DELETE"),
};