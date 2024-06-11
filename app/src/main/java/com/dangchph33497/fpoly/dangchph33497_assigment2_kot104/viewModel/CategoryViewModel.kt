package com.dangchph33497.fpoly.dangchph33497_assigment2_kot104.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dangchph33497.fpoly.dangchph33497_assigment2_kot104.entities.CategoryEntity
import com.dangchph33497.fpoly.dangchph33497_assigment2_kot104.repository.CategoryRepositry
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch

class CategoryViewModel(val categoryRepositry: CategoryRepositry) : ViewModel() {
    private val _categoryList = MutableStateFlow<List<CategoryEntity>>(emptyList())
    val categoryList: Flow<List<CategoryEntity>> get() = _categoryList

    init {
        viewModelScope.launch {
            val categories = categoryRepositry.getAllCategory()
            _categoryList.value = categories
            categoryRepositry.insertCategories(categories)
        }
    }
}
