//@Author William E. Velázquez A. - info@williamvelazquez.com
const path = require('path');
const UglifyJsPlugin = require("uglifyjs-webpack-plugin");
const MiniCssExtractPlugin = require('mini-css-extract-plugin');
const OptimizeCssAssetsPlugin = require('optimize-css-assets-webpack-plugin');
const CleanWebpackPlugin = require('clean-webpack-plugin');
const HtmlWebpackPlugin = require('html-webpack-plugin');

module.exports = (env) => {
  console.log('NODE_ENV: ', env.NODE_ENV); // 'local'
  console.log('Production: ', env.production); // true

  const plugins = [
    new MiniCssExtractPlugin({
      filename: "css/[name].[hash].css"
    }),
    new HtmlWebpackPlugin({
      filename: '../index.html',
      template: 'public/index.html',
      favicon: './public/favicon.ico',
      title: 'Hackaton BBVA 2019 | Legends Creed'
    })
  ]

  if (env.NODE_ENV === 'production') {
    plugins.push(
      new CleanWebpackPlugin()
    )
  }

  return {
    mode: (env.NODE_ENV === 'production') ? 'production' : 'none',
    resolve:{
      alias: {
        Utils: path.resolve(__dirname, 'src/utils/'),
        Constants: path.resolve(__dirname, 'src/constants/')
      }
    },
    optimization: {
      minimizer: [
        new UglifyJsPlugin({
          cache: true,
          parallel: true,
        }),
        new OptimizeCssAssetsPlugin({})
      ],
    },
    entry: {
      app: path.resolve(__dirname, 'src/entries/app.js'),
    },
    output: {
      path: (env.NODE_ENV === 'production') ? path.resolve(__dirname, '../app-mipyme/src/main/webapp/publico/') : path.resolve(__dirname, 'dist'),
      filename: 'js/[name].[hash].js',
      publicPath: (env.NODE_ENV === 'production') ? './publico/' : './dist/',
      chunkFilename: 'js/[id].[chunkhash].js',
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
          use: [
            MiniCssExtractPlugin.loader,
            'css-loader'
          ]
        },
        {
          test: /\.(jpg|png|gif|svg)$/,
          use: {
            loader: 'url-loader',
            options: {
              limit: 10000,
              fallback: 'file-loader',
              name: 'images/[name].[hash].[ext]',
            }
          }
        },
      ]
    },
    plugins
  }
}
