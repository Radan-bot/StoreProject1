import React from 'react';

function Header() {
  return (
    <header>
      <h1>Store Name</h1>
      <nav>
        <a href="/">Home</a> | <a href="/products">Products</a> | <a href="/contact">Contact</a>
      </nav>
    </header>
  );
}

export default Header;
