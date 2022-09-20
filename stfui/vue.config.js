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
    publicPath: "./",
    outputDir: "dist",
    assetsDir: "static",
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
        proxy: proxyObj,
        disableHostCheck: true
    },
};