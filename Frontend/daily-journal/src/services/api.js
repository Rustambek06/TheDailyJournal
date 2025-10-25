const BASE_URL = "http://localhost:8080/api";

export async function apiRequest(endpoint, method = "GET", body = null) {
  const options = {
    method,
    headers: { "Content-Type": "application/json" },
  };
  if (body) options.body = JSON.stringify(body);

  const res = await fetch(`${BASE_URL}${endpoint}`, options);

  if (!res.ok) throw new Error(`Ошибка: ${res.status}`);

  // Проверяем, есть ли тело у ответа
  const text = await res.text();
  return text ? JSON.parse(text) : null;
}
