<!doctype html>
<html>
<head>
    <meta name="layout" content="main"/>
    <title>Welcome to Grails</title>
</head>
<body>
<content tag="nav">
    <li class="dropdown">
        <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Cadastros <span class="caret"></span></a>
        <ul class="dropdown-menu">
            <g:each var="c" in="${grailsApplication.controllerClasses.sort { it.fullName } }">
                <li class="controller">
                    <g:link controller="${c.logicalPropertyName}">${c.name}</g:link>
                </li>
            </g:each>
        </ul>
    </li>
    <li class="dropdown">
        <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Frete <span class="caret"></span></a>
        <ul class="dropdown-menu">

        </ul>
    </li>
    <li class="dropdown">
        <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Relatorios <span class="caret"></span></a>
        <ul class="dropdown-menu">

        </ul>
    </li>
</content>

<div id="content" role="main">
<g:render template="/layouts/navbar" />
<g:render template="/layouts/navbar" />
<g:render template="/layouts/navbar" />
    <section class="row colset-2-its">
        <div id="cadastros" role="navigation">
            <h2>Cadastros:</h2>
            <ul>
                <g:each var="c" in="${grailsApplication.controllerClasses.sort { it.name } }">
                    <li class="controller">
                        <g:link controller="${c.logicalPropertyName}">${c.name}</g:link>
                    </li>
                </g:each>
            </ul>
        </div>
    </section>
</div>

</body>
</html>
