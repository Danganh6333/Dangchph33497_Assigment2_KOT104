package com.dangchph33497.fpoly.dangchph33497_assigment2_kot104.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dangchph33497.fpoly.dangchph33497_assigment2_kot104.entities.ProductEntity
import com.dangchph33497.fpoly.dangchph33497_assigment2_kot104.repository.ProductRepositry
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch

class ProductViewModel(private val productRepositry : ProductRepositry, private val categoryViewModel: CategoryViewModel) : ViewModel() {
    private val _productList = MutableStateFlow<List<ProductEntity>>(emptyList())
    val productList: Flow<List<ProductEntity>> get() = _productList

    init {
        viewModelScope.launch {
            categoryViewModel.categoryList.collect { categories ->
                val products = productRepositry.getAllProducts()
                _productList.value = products
            }
        }
    }
}
