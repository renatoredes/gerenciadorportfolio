# API Rest
### Sistema para gerenciar os dados do portfólio de projetos de uma empresa.

O[GerenciadorPotolio]disponibiliza uma API RESTful que permite o acesso aos módulos do sistema.

Recursos disponíveis na API: 

* [**CRUD (Create, Read, Update, Delete)  gestores**]
* [**CRUD (Create, Read, Update, Delete)  de projetos**]
* [**CRUD (Create, Read, Update, Delete)  de membros relacionados ao projeto**]



# Melhorias e cosumos dos serviços
Você pode utilizar os recursos de diversas mandeiras um exemplo é esse onde consumimos a api [GerenciadorPotolio] 
* [**Customização Sistema MVC com interfaces graficas**] 
[MVC Customização](https://github.com/renatoredes/gerenciadorportfoliomvc).

### Cadastrar novo Gerênte para um projeto http://localhost:8080/gerentes

+ Body
  
  {
   
    "nome": "Renato"
    
  }

+ Response 201 Created
 
 + Body
  {
    "id": 1,
    "nome": "Renato"
  }
