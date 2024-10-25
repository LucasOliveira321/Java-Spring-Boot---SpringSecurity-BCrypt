package com.api.controller;

import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/api/v0")
public class BaseController {
    //    Exemplo Prático de Versionamento Semântico
    //    Vamos imaginar uma API com essas versões e mudanças hipotéticas:
    //
    //    v1.0.0
    //    Endpoint /api/v1/users retorna uma lista básica de usuários.
    //    Endpoint /api/v1/users/{id} retorna os detalhes de um usuário específico.
    //    v1.0.2
    //    Correção de bug no endpoint /api/v1/users/{id} que agora retorna o erro 404 corretamente quando o usuário não é encontrado.
    //    Nenhuma mudança na estrutura da resposta ou nos parâmetros, então o cliente pode continuar usando o mesmo código.
    //    v1.1.0
    //    Adição de um novo endpoint /api/v1/users/search para pesquisa de usuários com base em nome ou e-mail.
    //    Os clientes que não usam esse novo recurso não precisam alterar nada, pois o restante da API permanece inalterado.
    //    v2.0.0
    //    Mudança no esquema de autenticação, requerendo o uso de token JWT em vez de Basic Auth.
    //    Mudança na estrutura de resposta do endpoint /api/v2/users, que agora retorna metadados adicionais sobre a lista de usuários.
    //    Essa versão exige adaptações dos consumidores da API para usarem o novo metodo de autenticação e para processarem a resposta atualizada.
}
