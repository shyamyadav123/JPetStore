#### Introduction
Restful重构JPetStore

这次是很认真的了，会尽量地遵循Rest的规范以及一些企业开发的内容，其中主要包括:
1. 统一的接口响应数据格式 (将错误的响应信息重新封装)
2. 统一的日志打印
3. 切面统一的异常处理

概括就是简化Controller的编写

① 请求参数、响应结果日志打印 -> 使用在controller方法外对做切面统一打印日志（非GET方法都会打印）

② 基础参数的校验 -> 使用hibernate validate做操作校验

④ 全局异常的捕获 -> 使用@ControllerAdvice写全局异常处理类控制异常展现方式

⑤ 对Result结果的封装 -> 实现ResponseBodyAdvice接口，对接口响应体统一处理