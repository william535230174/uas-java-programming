async function fetchMenus(category = null) {
    let url = '/api/menus';
    if (category && category !== "All") {
        url = '/api/menus/category/' + category;
    }
    const res = await fetch(url);
    return res.json();
}

function createCard(item) {
    const div = document.createElement('div');
    div.className = 'card';
    div.innerHTML = `
        <img src="${item.image || '/images/placeholder.png'}" alt="${item.name}">
        <h4>${item.name}</h4>
        <p>${item.description}</p>
        <p>Rp ${item.price.toLocaleString('id-ID')}</p>
        <div class="actions">
            <button class="add" data-id="${item.id}">Tambah</button>
        </div>
    `;
    return div;
}

async function refreshMenu(category = null) {
    const menus = await fetchMenus(category);
    const menuGrid = document.getElementById('menuGrid');
    menuGrid.innerHTML = '';

    menus.forEach(m => {
        menuGrid.appendChild(createCard(m));
    });

    document.querySelectorAll('.add').forEach(btn => {
        btn.addEventListener('click', async (e) => {
            const id = e.target.dataset.id;
            await fetch('/api/cart/add', {
                method: 'POST',
                headers: {'Content-Type':'application/json'},
                body: JSON.stringify({ id, quantity: 1 })
            });
            updateCartPreview();
        });
    });
}

async function updateCartPreview() {
    const res = await fetch('/api/cart');
    const data = await res.json();
    document.getElementById('cartCount').innerText = data.totalQty;
    document.getElementById('summaryQty').innerText = data.totalQty;
    document.getElementById('summaryTotal').innerText = data.total.toLocaleString('id-ID');
}

document.querySelectorAll('.tab').forEach(tabBtn => {
    tabBtn.addEventListener('click', () => {
        const cat = tabBtn.dataset.cat;
        refreshMenu(cat);
    });
});

document.getElementById('btnCart').addEventListener('click', () => {
    window.location.href = '/cart.html';
});

document.getElementById('btnLogin').addEventListener('click', () => {
    window.location.href = '/login.html';
});

refreshMenu().then(updateCartPreview);

