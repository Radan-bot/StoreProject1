// src/ProductList.js
import React from 'react';
import ProductCard from './ProductCard';

function ProductList() {
  const products = [
    { name: 'Product 1', price: 20, image: 'path-to-image1.jpg' },
    { name: 'Product 2', price: 35, image: 'path-to-image2.jpg' },
    { name: 'Product 3', price: 50, image: 'path-to-image3.jpg' },
  ];

  return (
    <div className="product-list">
      {products.map((product, index) => (
        <ProductCard key={index} {...product} />
      ))}
    </div>
  );
}

export default ProductList;
