import React, { useState } from 'react';

const AddProduct = () => {
  const [productData, setProductData] = useState({
    productCode: '',
    productName: '',
    originCountry: '',
    price: '',
    cost: '',
    imageUrl: '',
    description: '',
  });

  const handleChange = (e) => {
    const { name, value } = e.target;
    setProductData((prevData) => ({
      ...prevData,
      [name]: value,
    }));
  };

  const handleSubmit = async (e) => {
    e.preventDefault();

    const formData = new FormData();

    Object.entries(productData).forEach(([key, value]) => {
      formData.append(key, value);
    });

    try {
      const response = await fetch('http://localhost:8000/api/admin/product/add', {
        method: 'POST',
        body: formData,
        headers: {
          'Content-Type': 'multipart/form-data',
        },
        mode: 'cors',
      });


      if (response.ok) {
        console.log('Product added successfully');
      } else {
        console.error('Error adding product:', response.statusText);
      }
    } catch (error) {
      console.error('Error adding product:', error.message);
    }
  };

  return (
    <div>
      <h1>Add Product Page</h1>
      <form onSubmit={handleSubmit}>
        <label htmlFor="productCode">Product Code:</label>
        <input
          type="text"
          id="productCode"
          name="productCode"
          value={productData.productCode}
          onChange={handleChange}
        />

        <label htmlFor="productName">Product Name:</label>
        <input
          type="text"
          id="productName"
          name="productName"
          value={productData.productName}
          onChange={handleChange}
        />

        <label htmlFor="originCountry">Origin Country:</label>
        <input
          type="text"
          id="originCountry"
          name="originCountry"
          value={productData.originCountry}
          onChange={handleChange}
        />

        <label htmlFor="price">Price:</label>
        <input
          type="text"
          id="price"
          name="price"
          value={productData.price}
          onChange={handleChange}
        />

        <label htmlFor="cost">Cost:</label>
        <input
          type="text"
          id="cost"
          name="cost"
          value={productData.cost}
          onChange={handleChange}
        />

        <label htmlFor="image">Image URL:</label>
        <input
          type="text"
          id="image"
          name="imageUrl"
          value={productData.imageUrl}
          onChange={handleChange}
        />

        <label htmlFor="description">Description:</label>
        <textarea
          id="description"
          name="description"
          value={productData.description}
          onChange={handleChange}
        ></textarea>


        <input type="submit" value="Add Product" />
      </form>
    </div>
  );
};

export default AddProduct;
