const path = require('path')

module.exports = {
  outputDir: path.resolve(__dirname, 'target/dist'),
  assetsDir: 'assets',
  publicPath: '/expenses/',

  transpileDependencies: [
    'vuetify'
  ]
}
