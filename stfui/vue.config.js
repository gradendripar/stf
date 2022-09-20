let proxyObj = {};
proxyObj['/'] = {
    ws: false,
    target: 'http://localhost:8888',
    changeOrigin: true,
    pathRewrite: {
        '^/': '/'
    }
};

module.exports = {
    // 公共路径(必须有的)
    publicPath: "./",
    // 输出文件目录
    outputDir: "dist",
    // 静态资源存放的文件夹(相对于ouputDir)
    assetsDir: "static",
    // 不需要生产环境的设置false可以减小dist文件大小，加速构建
    productionSourceMap: true,
    css: {
        loaderOptions: {
            less: {
                javascriptEnabled: true
            }
        }
    },
    devServer: {
        overlay: {
            // 让浏览器 overlay 同时显示警告和错误
            warnings: true,
            errors: true
        },
        https: false, // https:{type:Boolean}
        open: true, //配置后自动启动浏览器
        hotOnly: true, // 热更新
        proxy: proxyObj
    }
};