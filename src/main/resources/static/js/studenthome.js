class Posts {
  constructor() {
    this.buttonSelector = '._getPosts';
    this.postEndpoint = '//jsonplaceholder.typicode.com/posts';
  }

  /**
   * Init "app"
   * @returns {void}
   */
  init() {
    this.addClickHandler();
  }

  /**
   * Add click handler to button
   * @returns {void}
   */
  addClickHandler() {
    const bodyEl = [...document.getElementsByTagName('body')];

    bodyEl[0].addEventListener('click', (e) => {
      if (e.target.matches(this.buttonSelector)) {
        this.fetchPosts(this.postId);
        e.preventDefault();
        e.stopPropagation();
      }
    }, false);
  }

  /**
   * Fetch posts from API endpoint
   * @returns {void}
   */
  fetchPosts() {
    fetch(this.postEndpoint, {
      method: 'GET',
    })
    .then((response) => response.json())
    .then((response) => {
      this.renderPosts(this.formatResponse(response, 3));
    })
    .catch((error) => {
      console.error(`Endpoint returned an error: ${error}`);
    });
  }

  /**
   * Return posts from a user
   * @param {array} posts data
   * @param {id} user id
   * @returns {void}
   */
  formatResponse(data, userId) {
    const userPosts = data.filter((val) => val.userId === userId);
    return userPosts;
  }

  /**
   * Renders posts to DOM
   * @param {array} posts data
   * @returns {void}
   */
  renderPosts(data) {
    const markup = data.map((val, i, data) => this.getPostMarkup(val));
    $('._posts').append(markup);
  }

  /**
   * Returns formatted post markup
   * @param {object} post data
   * @return {string} markup
   */
  getPostMarkup = (post) => `
      <article class="post" id="postID_${post.id}">
        <h3 class="post__title">${post.id}) ${post.title}</h3>
        <ul class="post__meta">
          <li class="post__meta__user">User ID: ${post.userId}</li>
        </ul>
        <p class="post__body">${post.body}</p>
      </article>
    `;
}

// New instance of Post
const posts = new Posts();

// Document ready
document.addEventListener('DOMContentLoaded', posts.init());