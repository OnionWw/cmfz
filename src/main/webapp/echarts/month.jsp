<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<div id="main" style="width: 600px;height:400px;"></div>
<script type="text/javascript">
    // 基于准备好的dom，初始化echarts实例
    var myChart = echarts.init(document.getElementById('main'));

    // 指定图表的配置项和数据
    var option = {
        title: {
            text: '近期注册人数'
        },
        tooltip: {},
        legend: {
            data:['近期注册人数']
        },
        xAxis: {
            data: ["1个月内","2个月内","3个月内"]
        },
        yAxis: {},
        series: [{
            name: '用户数量',
            type: 'bar',
        }]
    };
    // 使用刚指定的配置项和数据显示图表。
    myChart.setOption(option);
    $.ajax({
        type: "get",
        url: "${pageContext.request.contextPath}/echarts/getMonCount",
        dataType: "JSON",
        success: function (data) {
            myChart.setOption({
                series: [{
                    data:data.data
                }]
            })
        }
    })
</script>
