module.exports = {
    devServer: {
        proxy: {
            "localhost/": {
                target: "http://localhost:8081/",
                changeOrigin: true,
                secure:false,
                ws: false,
                pathRewrite: {'/localhost':''},
                logLevel: 'debug' 
            }
        }
    }
}
