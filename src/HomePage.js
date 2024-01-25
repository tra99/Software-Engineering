import React, { useEffect, useState } from 'react';

const ProductList = () => {
  const [productModels, setProductModels] = useState([]);

  useEffect(() => {
    const fetchData = async () => {
      try {
        const response = await fetch('http://localhost:8000/api/admin/product/list');
        const data = await response.json();
        setProductModels(data);
        console.log(response);
      } catch (error) {
        console.error('Error fetching data:', error);
      }
    };

    fetchData();
  }, []);

  return (
    <div>
      <h1>Product List</h1>
      <table>
        <thead>
          <tr>
            <th>Product Code</th>
            <th>Product Name</th>
            <th>Origin Country</th>
            <th>Price</th>
            <th>Cost</th>
            <th>Image URL</th>
            <th>Description</th>
            <th>Edit</th>
          </tr>
        </thead>
        <tbody>
          {productModels.map((item) => (
            <tr key={item.code}>
              <td>{item.code}</td>
              <td>{item.name}</td>
              <td>{item.country}</td>
              <td>${item.price}</td>
              <td>{item.cost}</td>
              <td><img style={{width:"100px"}} src={item.image} alt="React Image" /></td>
              <td>{item.description}</td> 
              <td>
                <a href={`/update-product?productCode=${item.productCode}`} className="edit-button">
                  Edit
                </a>
              </td>
            </tr>
          ))}
        </tbody>
      </table>
      <a href="/add-product" className="add-product-btn">
        Add Product
      </a>
    </div>
  );
};

export default ProductList;