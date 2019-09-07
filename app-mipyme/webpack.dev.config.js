//@Author William E. Velázquez A. - info@williamvelazquez.com
const path = require('path');
const HtmlWebpackPlugin = require('html-webpack-plugin');

module.exports = {
  resolve:{
    alias: {
      Utils: path.resolve(__dirname, 'src/utils/'),
      Constants: path.resolve(__dirname, 'src/constants/')
    }
  },
  entry: {
    app: path.resolve(__dirname, 'src/entries/app.js'),
  },
  output: {
    path: path.resolve(__dirname, 'dist'),
    filename: 'js/[name].js'
  },
  devServer: {
    port: 3000,
  },
  node: {
    fs: 'empty',
    net: 'empty',
    tls: 'empty',
  },
  module: {
    rules: [
      {
        test: /\.(js|jsx)$/,
        exclude: /(node_modules)/,
        use: {
          loader: 'babel-loader',
          options: {
            presets: ['env', 'react', 'stage-2'],
          }
        },
      },
      {
        test: /\.css$/,
        use: ['style-loader', 'css-loader']
      },
      {
        test: /\.(jpg|png|gif|svg)$/,
        use: {
          loader: 'url-loader',
          options: {
            limit: 1000000,
            fallback: 'file-loader',
            name: 'images/[name].[hash].[ext]',
          }
        }
      },
    ]
  },
  plugins: [
    new HtmlWebpackPlugin({ 
      filename: './index.html',
      template: './public/index.html'
    })
  ]
}
