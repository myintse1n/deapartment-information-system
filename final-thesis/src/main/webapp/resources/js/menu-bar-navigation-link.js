document.addEventListener('DOMContentLoaded', () => {
            const navLinks = document.querySelectorAll('.nav-link');

            navLinks.forEach(link => {
                link.addEventListener('click', (e) => {
                    const href = e.currentTarget.getAttribute('href');
                    if (href.includes('#')) {
                        e.preventDefault();
                        const targetHref = e.currentTarget.getAttribute('data-href') || '/';
                        const hash = href.split('#')[1];
                        window.location.href = `${targetHref}#${hash}`;
                    }
                });
            });
        });