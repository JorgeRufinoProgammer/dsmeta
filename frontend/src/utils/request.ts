//Se nao existir a variavel de ambiente "VITE_BACKEND_URL", ele vai usar o localhost
export const BASE_URL = import.meta.env.VITE_BACKEND_URL ?? "http://localhost:8080";