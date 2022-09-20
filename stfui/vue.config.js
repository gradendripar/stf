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
    devServer: {
        proxy: proxyObj
    }
};