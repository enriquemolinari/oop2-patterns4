package unrn.proxy;

public class Main {

    public static void main(String[] args) {
        var posts = new CachedPosts(
                new HttpPosts("https://jsonplaceholder.typicode.com/posts"));

        long start = System.currentTimeMillis();
        var postsList = posts.list();
        long end = System.currentTimeMillis();
        System.out.println((end - start) / 1000f);

        System.out.println("Cantidad de posts: " + postsList.size());
        for (Post post : postsList) {
            System.out.println(post);
            System.out.println("---------------");
        }

        long start2 = System.currentTimeMillis();
        var postsList2 = posts.list();
        long end2 = System.currentTimeMillis();
        System.out.println("Una vez en el cache: " + (end2 - start2) / 1000f);

    }
}
