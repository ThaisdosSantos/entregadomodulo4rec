<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Crud Java - Lista de Cadastro</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
</head>
<body>
    <nav class="navbar navbar-expand-lg navbar-light bg-light">
        <div class="container-fluid">
            <a class="navbar-brand" href="#">Navbar</a>
            <button class="navbar-toggler" type="button"
                data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent"
                aria-controls="navbarSupportedContent" aria-expanded="false"
                aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarSupportedContent">
                <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                    <li class="nav-item"><a class="nav-link active"
                        aria-current="page" href="Index.html">Home</a></li>
                    <li class="nav-item"><a class="nav-link" href="cadastrofind ">Lista
                            de clientes Cadastrados</a></li>
                </ul>
                <form action="cadastrofind" method="GET" class="d-flex">
                    <input name="pesquisa" class="form-control me-2" type="search"
                        placeholder="Informe o nome ou CPF" aria-label="Search">
                    <button class="btn btn-primary" type="submit">Buscar</button>
                </form>
            </div>
        </div>
    </nav>
    <br>
    <div class="container">
        <div class="row">
            <div class="cold-md-7">
                <hr>
                <h3>Lista de Cadastro</h3>
                <hr>
                <table class="table">
                    <thead>
                        <tr>
                            <th>#</th>
                            <th>Nome</th>
                            <th>CPF</th>
                            <th>RG</th>
                            <th>Nascimento</th>
                            <th>Sexo</th>
                            <th>Email</th>
                            <th>Senha</th>
                        </tr>

                    </thead>
                    <tbody>
                        <c:forEach items="${cadastros}" var="cadastro">
                            <tr>
                                <td>${cadastro.codCliente}</td>
                                <td>${cadastro.nome}</td>
                                <td>${cadastro.cpf}</td>
                                <td>${cadastro.rg}</td>
                                <td>${cadastro.nascimento}</td>
                                <td>${cadastro.sexo}</td>
                                <td>${cadastro.email}</td>
                                <td>${cadastro.senha}</td>
                                <td>
                                    <a href="cadastrodelete?cadastrocodCliente=${cadastro.codCliente}">Deletar</a>
                                    <a href="CadastroAtualizar?cadastrocodCliente=${cadastro.codCliente}">Atualizar</a>
                                </td>
                            </tr>
                        </c:forEach>

                    </tbody>
                </table>
            </div>
        </div>
    </div>
    <!-- JavaScript Bundle with Popper -->
    <script
        src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
        crossorigin="anonymous"></script>
</body>

</html>