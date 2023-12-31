INSERT INTO NOTES (title, content)
VALUES
    ('Bucket List', 'Skydiving in Dubai\n2. Explore the Amazon Rainforest\n3. Attend the Rio Carnival'),

    ('Recipe Ideas', 'Spicy Thai Coconut Soup\n2. Homemade Sushi Rolls\n3. Chocolate Lava Cake Recipe'),

    ('Travel Diary', 'Just returned from an amazing trip to Bali. The beaches, temples, and food were incredible!'),

    ('Code Snippets', 'Implement JWT authentication\n2. Build a RESTful API with Spring Boot\n3. Create a responsive CSS grid layout'),

    ('Book Recommendations', '"The Alchemist" by Paulo Coelho\n2. "The Great Gatsby" by F. Scott Fitzgerald\n3. "Sapiens: A Brief History of Humankind" by Yuval Noah Harari'),

    ('Fitness Goals', 'Run a marathon in under 4 hours\n2. Achieve 10 consecutive pull-ups\n3. Learn to do a handstand'),

    ('Project Ideas', 'Build a smart mirror\n2. Develop a language learning app\n3. Create an AI-driven chatbot'),

    ('Movie Watchlist', '"Inception" - Christopher Nolan\n2. "The Shawshank Redemption" - Frank Darabont\n3. "Pulp Fiction" - Quentin Tarantino'),

    ('Gardening Notes', 'Plant tulips in the front garden\n2. Prune the rose bushes\n3. Start a herb garden in pots'),

    ('Random Thoughts', 'Life is an adventure waiting to happen!\n2. Do not forget to call Mom on her birthday.\n3. Learn to play the piano this year.');

INSERT INTO USERS (username, password, role)
VALUES
    ('user1', '$2a$10$sto0E69p8n17LmYLrngZBeVwQnPBNBhH9wss5QPDyzywmiyculOGW', 'ADMIN'),--password1
    ('user2', '$2a$10$MfzH/MWjhhdHlSIT/YSMhO66e0.ShZqseaGyb993KsXmRxWdhPf4q', 'SUPPORT'),--password2
    ('user3', '$2a$10$XvzC1677cQtI/6bWhiYfH.iq1JwrB.G2ZRDufZfq6KimvLfBRtnm2', 'VIEWER');--password3