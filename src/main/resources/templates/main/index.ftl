<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>MyBatis Helper</title>
    <#include "../import.ftl"/>
</head>
<body>
<div class="container">
    <nav class="navbar navbar-default">
        <div class="container-fluid">
            <!-- Brand and toggle get grouped for better mobile display -->
            <div class="navbar-header">
                <button type="button" class="navbar-toggle collapsed" data-toggle="collapse"
                        data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
                    <span class="sr-only">MyBatisHelper</span>
                </button>
                <a class="navbar-brand" href="#">MyBatisHelper</a>
            </div>

            <!-- Collect the nav links, forms, and other content for toggling -->
            <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                <ul class="nav navbar-nav">
                    <li class="dropdown">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true"
                           aria-expanded="false" title="当前数据源：boss">配置数据源<span class="caret"></span></a>
                        <ul class="dropdown-menu">
                            <li><a href="#">新建配置</a></li>
                            <li role="separator" class="divider"></li>
                            <li><a href="#">BSS(oracle)</a></li>
                            <li><a href="#">zwBoss(mysql)</a></li>
                            <li><a href="#">boss(SQLServer)</a></li>
                            <li role="separator" class="divider"></li>
                        </ul>
                    </li>
                    <li><a href="#">逆向工程</a></li>
                    <li><a href="#">SQL生成</a></li>
                </ul>
            </div><!-- /.navbar-collapse -->
        </div><!-- /.container-fluid -->
    </nav>

    <div class="panel panel-default">
        <div class="panel-heading">FreeMarker</div>
        <div class="panel-body">

            <table border="1">
                <#if errors?? && (errors?size > 0)>
                    <tr>
                        <td>字段名</td>
                        <td>错误信息</td>
                        <td>操作</td>
                    </tr>
                    <#list errors as err>
                        <tr>
                        <td>${err.field}</td>
                        <td>${err.defaultMessage}</td>
                        <td>
                            <a href="">修改</a>
                            <a href="">删除</a>
                        </td>
                        </tr>
                    </#list>
                <#else>
                    没有数据
                </#if>
            </table>

            <a href="addpage">新增</a>
            <img src="/static/imgs/test.jpg">

        </div>
    </div>
</div>

</body>
</html>