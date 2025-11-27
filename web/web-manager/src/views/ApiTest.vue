<template>
  <div class="api-test">
    <h2>API 测试</h2>
    <div class="test-container">
      <div class="test-buttons">
        <button @click="testGet" class="btn btn-success">GET 测试</button>
        <button @click="testPost" class="btn btn-info">POST 测试</button>
        <button @click="testPut" class="btn btn-warning">PUT 测试</button>
        <button @click="testDelete" class="btn btn-danger">DELETE 测试</button>
      </div>
      
      <div v-if="loading" class="loading">请求中...</div>
      
      <div v-if="result" class="result">
        <h3>响应结果：</h3>
        <pre>{{ JSON.stringify(result, null, 2) }}</pre>
      </div>
      
      <div v-if="error" class="error">
        <h3>错误信息：</h3>
        <pre>{{ error }}</pre>
      </div>
    </div>
  </div>
</template>

<script setup>
import { ref } from 'vue'
import axios from 'axios'

const loading = ref(false)
const result = ref(null)
const error = ref(null)

const testGet = async () => {
  loading.value = true
  result.value = null
  error.value = null
  
  try {
    const response = await axios.get('/api/hello')
    result.value = response.data
  } catch (err) {
    error.value = err.message
  } finally {
    loading.value = false
  }
}

const testPost = async () => {
  loading.value = true
  result.value = null
  error.value = null
  
  try {
    const response = await axios.post('/api/data', {
      message: 'Hello from Vue',
      timestamp: Date.now()
    })
    result.value = response.data
  } catch (err) {
    error.value = err.message
  } finally {
    loading.value = false
  }
}

const testPut = async () => {
  loading.value = true
  result.value = null
  error.value = null
  
  try {
    const response = await axios.put('/api/data/1', {
      name: 'Updated Item',
      status: 'active'
    })
    result.value = response.data
  } catch (err) {
    error.value = err.message
  } finally {
    loading.value = false
  }
}

const testDelete = async () => {
  loading.value = true
  result.value = null
  error.value = null
  
  try {
    const response = await axios.delete('/api/data/1')
    result.value = response.data
  } catch (err) {
    error.value = err.message
  } finally {
    loading.value = false
  }
}
</script>

<style scoped>
.api-test {
  background: white;
  padding: 2rem;
  border-radius: 12px;
  box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
}

.api-test h2 {
  margin-bottom: 1.5rem;
  color: #333;
}

.test-container {
  display: flex;
  flex-direction: column;
  gap: 1.5rem;
}

.test-buttons {
  display: flex;
  gap: 1rem;
  flex-wrap: wrap;
}

.btn {
  padding: 0.75rem 1.5rem;
  border: none;
  border-radius: 6px;
  color: white;
  font-weight: 500;
  cursor: pointer;
  transition: all 0.3s ease;
}

.btn:hover {
  transform: translateY(-2px);
  box-shadow: 0 4px 8px rgba(0, 0, 0, 0.2);
}

.btn-success { background: #28a745; }
.btn-info { background: #17a2b8; }
.btn-warning { background: #ffc107; color: #212529; }
.btn-danger { background: #dc3545; }

.loading {
  text-align: center;
  padding: 1rem;
  background: #e3f2fd;
  border-radius: 6px;
  color: #1976d2;
}

.result, .error {
  background: #f8f9fa;
  padding: 1rem;
  border-radius: 6px;
  border-left: 4px solid #28a745;
}

.error {
  border-left-color: #dc3545;
}

.result h3, .error h3 {
  margin-bottom: 0.5rem;
  color: #333;
}

pre {
  background: #f1f1f1;
  padding: 1rem;
  border-radius: 4px;
  overflow-x: auto;
  font-size: 0.9rem;
  line-height: 1.4;
}
</style>