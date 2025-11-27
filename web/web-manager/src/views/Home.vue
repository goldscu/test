<template>
  <div class="home">
    <div class="welcome-card">
      <h1>欢迎使用 Web Manager</h1>
      <p>这是一个基于 Vue 3 的现代化前端项目</p>
      <div class="features">
        <div class="feature-item">
          <h3>🚀 Vue 3</h3>
          <p>使用最新的 Vue 3 Composition API</p>
        </div>
        <div class="feature-item">
          <h3>⚡ Vite</h3>
          <p>极速的开发体验和构建速度</p>
        </div>
        <div class="feature-item">
          <h3>🔗 Vue Router</h3>
          <p>单页应用路由管理</p>
        </div>
        <div class="feature-item">
          <h3>📦 Pinia</h3>
          <p>状态管理解决方案</p>
        </div>
      </div>
      <div class="actions">
        <router-link to="/api-test" class="btn btn-primary">
          测试 API
        </router-link>
      </div>
    </div>
  </div>
</template>

<style scoped>
.home {
  display: flex;
  justify-content: center;
  align-items: center;
  min-height: 60vh;
}

.welcome-card {
  background: white;
  padding: 3rem;
  border-radius: 12px;
  box-shadow: 0 4px 6px rgba(0, 0, 0, 0.1);
  text-align: center;
  max-width: 600px;
  width: 100%;
}

.welcome-card h1 {
  color: #333;
  margin-bottom: 1rem;
  font-size: 2.5rem;
}

.welcome-card p {
  color: #666;
  margin-bottom: 2rem;
  font-size: 1.1rem;
}

.features {
  display: grid;
  grid-template-columns: repeat(auto-fit, minmax(150px, 1fr));
  gap: 1.5rem;
  margin-bottom: 2rem;
}

.feature-item {
  background: #f8f9fa;
  padding: 1.5rem;
  border-radius: 8px;
  border: 1px solid #e9ecef;
}

.feature-item h3 {
  margin-bottom: 0.5rem;
  color: #495057;
}

.feature-item p {
  color: #6c757d;
  font-size: 0.9rem;
  margin: 0;
}

.actions {
  margin-top: 2rem;
}

.btn {
  display: inline-block;
  padding: 0.75rem 2rem;
  border-radius: 6px;
  text-decoration: none;
  font-weight: 500;
  transition: all 0.3s ease;
}

.btn-primary {
  background: linear-gradient(135deg, #667eea 0%, #764ba2 100%);
  color: white;
}

.btn-primary:hover {
  transform: translateY(-2px);
  box-shadow: 0 4px 8px rgba(0, 0, 0, 0.2);
}
</style>