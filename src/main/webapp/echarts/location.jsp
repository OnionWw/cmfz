<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<!-- 为 ECharts 准备一个具备大小（宽高）的 DOM -->
<div id="main1" style="width: 600px;height:400px;"></div>

<script type="text/javascript">








    var myChart = echarts.init(document.getElementById('main1'));

    option = {
        title : {
            text: 'App用户分布',
            subtext: '纯属虚构',
            left: 'center'
        },
        tooltip : {
            trigger: 'item'
        },
        legend: {
            orient: 'vertical',
            left: 'left',
            data:['用户数量']
        },
        visualMap: {
            min: 0,
            max: 2500,
            left: 'left',
            top: 'bottom',
            text:['高','低'],           // 文本，默认为数值文本
            calculable : true
        },
        toolbox: {
            show: true,
            orient : 'vertical',
            left: 'right',
            top: 'center',
            feature : {
                mark : {show: true},
                dataView : {show: true, readOnly: false},
                restore : {show: true},
                saveAsImage : {show: true}
            }
        },
        series : [
            {
                name: '用户数量',
                type: 'map',
                mapType: 'china',
                roam: false,
                label: {
                    normal: {
                        show: false
                    },
                    emphasis: {
                        show: true
                    }
                }
            }

        ]
    };
    myChart.setOption(option)
    $.ajax({
        type: "get",
        url: "${pageContext.request.contextPath}/echarts/getProCount",
        dataType: "JSON",
        success: function (data) {
            myChart.setOption({
                series: [{
                    data: data.data
                }]
            })
        }
    })
</script>
